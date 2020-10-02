public class schedule {
    private String term;
    private course firstCourse;
    private course secondCourse;


    public schedule(String _term, String _blockOrder1, String _courseTitle1, String _blockOrder2, String _courseTitle2) {
        setTerm(_term);
        firstCourse = new course(_blockOrder1, _courseTitle1);
        secondCourse = new course(_blockOrder2, _courseTitle2);
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTerm() {
        return term;
    }

    public void setFirstCourse(String _blockOrder, String _courseTitle) {
        firstCourse.setBlockOrder(_blockOrder);
        firstCourse.setCourseTitle(_courseTitle);
    }

    public course getFirstCourse() {
        return firstCourse;
    }

    public void setSecondCourse(String _blockOrder, String _courseTitle) {
        secondCourse.setBlockOrder(_blockOrder);
        secondCourse.setCourseTitle(_courseTitle);
    }

    public course getSecondCourse() {
        return secondCourse;
    }
}
