package lesson7.dto;

public class ProductDto {
        private Long id;
        private String name;
        private Integer price;
        private Integer count;

    public ProductDto(Long id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
