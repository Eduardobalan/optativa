package br.com.albus.generic;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Map;
import java.util.Objects;

public class SortPaginatorFilter {
    private int page = 0;
    private int size = 10;
    private Sort sort;

    public SortPaginatorFilter(Map<String, String[]> requestMap) {
        this.setPage(RequestFilterHelper.getValueFilter((String[])requestMap.get("page")));
        this.setSize(RequestFilterHelper.getValueFilter((String[])requestMap.get("size")));
        this.setSort(RequestFilterHelper.getValueFilter((String[])requestMap.get("direction")), RequestFilterHelper.getValueFilter((String[])requestMap.get("sort")));
    }

    public void setPage(String pageStr) {
        if (pageStr != null) {
            this.page = Integer.parseInt(pageStr) - 1;
        }

    }

    public void setSize(String sizeStr) {
        if (sizeStr != null) {
            this.size = Integer.parseInt(sizeStr);
        }

    }

    public void setSort(String direction, String fieldSort) {
        if (!Objects.isNull(fieldSort)) {
            Sort.Order order = createSortOrder(direction, fieldSort);
            this.sort = new Sort(new Sort.Order[]{order});
        }
    }

    public void setSortIgnoreCase(String direction, String fieldSort) {
        if (!Objects.isNull(fieldSort)) {
            Sort.Order order = createSortOrder(direction, fieldSort);
            this.sort = new Sort(new Sort.Order[]{order.ignoreCase()});
        }
    }

    public PageRequest getPageRequest() {
        PageRequest pageRequest;
        if (this.sort == null) {
            pageRequest = new PageRequest(this.page, this.size);
        } else {
            pageRequest = new PageRequest(this.page, this.size, this.sort);
        }

        return pageRequest;
    }

    private static Sort.Order createSortOrder(String directionStr, String fieldSort) {
        Sort.Direction direction = getSortDirectionFromString(directionStr);
        return new Sort.Order(direction, fieldSort);
    }

    private static Sort.Direction getSortDirectionFromString(String directionStr) {
        return Objects.isNull(directionStr) ? Sort.Direction.ASC : Sort.Direction.fromString(directionStr);
    }
}
