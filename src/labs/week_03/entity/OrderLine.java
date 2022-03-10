package labs.week_03.entity;

public class OrderLine {
    private Item item;
    private Boolean specialOffer;
    private Integer count;

    public OrderLine(Item item, Boolean specialOffer, Integer count) {
        this.item = item;
        this.specialOffer = specialOffer;
        this.count = count;
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Boolean getSpecialOffer() {
        return this.specialOffer;
    }

    public void setSpecialOffer(Boolean specialOffer)
    {
        this.specialOffer = specialOffer;
    }

    public Integer getCount()
    {
        return count;
    }

    public void setCount(Integer count)
    {
        this.count = count;
    }
}
