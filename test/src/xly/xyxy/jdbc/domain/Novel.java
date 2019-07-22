package xly.xyxy.jdbc.domain;

/**
 * @BelongsProject: test
 * @BelongsPackage: xly.xyxy.jdbc.domain
 * @Author: 99847
 * @CreateTime: 2019-07-22 09:48
 * @Description: 实体类Novel
 */
public class Novel {
    private Integer id;
    private String name;
    private String author;

    public Novel() {
    }

    public Novel(Integer id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Novel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
