public class course {
    private String blockOrder;
    private String courseTitle;

    public course(String _blockOrder, String _courseTitle) {
        setBlockOrder(_blockOrder);
        setCourseTitle(_courseTitle);
    }

    public void setBlockOrder(String blockOrder) {
        this.blockOrder = blockOrder;
    }

    public String getBlockOrder() {
        return blockOrder;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseTitle() {
        return courseTitle;
    }
}
