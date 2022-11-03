package luochao.entity;

public class Covid19_Data {
    private long id;
    private String name;
    private Integer local_confirm_add;
    private Integer nowConfirm;
    private Integer confirm;
    private Integer dead;

    public Covid19_Data() {
    }

    @Override
    public String toString() {
        return "Covid19_Data{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", local_confirm_add=" + local_confirm_add +
                ", nowConfirm=" + nowConfirm +
                ", confirm=" + confirm +
                ", dead=" + dead +
                '}';
    }

    public Covid19_Data(String name, Integer local_confirm_add, Integer nowConfirm, Integer confirm, Integer dead) {
        this.name = name;
        this.local_confirm_add = local_confirm_add;
        this.nowConfirm = nowConfirm;
        this.confirm = confirm;
        this.dead = dead;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLocal_confirm_add() {
        return local_confirm_add;
    }

    public void setLocal_confirm_add(Integer local_confirm_add) {
        this.local_confirm_add = local_confirm_add;
    }

    public Integer getNowConfirm() {
        return nowConfirm;
    }

    public void setNowConfirm(Integer nowConfirm) {
        this.nowConfirm = nowConfirm;
    }

    public Integer getConfirm() {
        return confirm;
    }

    public void setConfirm(Integer confirm) {
        this.confirm = confirm;
    }

    public Integer getDead() {
        return dead;
    }

    public void setDead(Integer dead) {
        this.dead = dead;
    }
}
