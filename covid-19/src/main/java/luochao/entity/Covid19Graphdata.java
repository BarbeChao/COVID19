package luochao.entity;

public class Covid19Graphdata {
    private Long id;

    private Integer localConfirmadd;

    private Integer localinfectionadd;

    private String date;

    private String year;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLocalConfirmadd() {
        return localConfirmadd;
    }

    public void setLocalConfirmadd(Integer localConfirmadd) {
        this.localConfirmadd = localConfirmadd;
    }

    public Integer getLocalinfectionadd() {
        return localinfectionadd;
    }

    public void setLocalinfectionadd(Integer localinfectionadd) {
        this.localinfectionadd = localinfectionadd;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}