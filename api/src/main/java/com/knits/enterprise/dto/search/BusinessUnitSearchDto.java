package com.knits.enterprise.dto.search;

import com.knits.enterprise.model.company.BusinessUnit;
import lombok.*;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusinessUnitSearchDto extends AbstractSearchableDto<BusinessUnit> {

    private String title;
    private String startDateFrom;
    private Long createdBy;

    @Override
    public Specification<BusinessUnit> getSpecification() {

        return (root, query, criteriaBuilder) -> {

            query.distinct(true);
            Predicate noFiltersApplied = criteriaBuilder.conjunction();
            List<Predicate> filters = new ArrayList<>();
            filters.add(noFiltersApplied);

            if (Strings.isNotBlank(title)) {
                Predicate titleAsPredicate = criteriaBuilder.like(root.get("title"), "%" + title + "%");
                filters.add(titleAsPredicate);
            }

            if (createdBy != null) {
                Predicate createdBuAsPredicate = criteriaBuilder.equal(root.get("createdBy").get("id"), createdBy);
                filters.add(createdBuAsPredicate);
            }

            if (Strings.isNotBlank(startDateFrom)) {
                ZonedDateTime from = ZonedDateTime.parse(startDateFrom, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                Predicate startDateAsPredicate = criteriaBuilder.greaterThanOrEqualTo(root.get("startDate"), from);
                filters.add(startDateAsPredicate);
            }

            return criteriaBuilder.and(filters.toArray(new Predicate[filters.size()]));
        };
    }
}
