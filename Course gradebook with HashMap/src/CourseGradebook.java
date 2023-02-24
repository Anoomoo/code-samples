import java.util.*;

public class CourseGradebook extends Gradebook {
    // Declare any protected fields here (change placeholder field below)
    protected HashMap<Integer, HashMap<String, Double>> map1;

    public CourseGradebook() {
        map1 = new HashMap<>();
    }
    @Override
    public HashMap<Integer, Double> getAssignmentScores(String assignmentName) {
        // Your code here (remove placeholder line below)
        HashMap<Integer, Double> assignmentScores = new HashMap<>();
        for (Integer ID: map1.keySet()) {
            HashMap<String, Double> studentScores = map1.get(ID);
            if (studentScores.containsKey(assignmentName)) {
                Double score = studentScores.get(assignmentName);
                assignmentScores.put(ID, score);
            }
        }
        return assignmentScores;
    }

    public double getScore1(String assignmentName, Integer studentID) {
        // Your code here
        HashMap<String, Double> studentGrades = map1.get(studentID);
        if (studentGrades == null) {
            return Double.NaN;
        } else {
            Double score = studentGrades.get(assignmentName);
            if (score == null) {
                return Double.NaN;
            } else {
                return score;
            }
        }
    }

    @Override
    public ArrayList<String> getSortedAssignmentNames() {
        // Your code here (remove placeholder line below)
        ArrayList<String> assignmentNames = new ArrayList<String>();
        for (Integer ID: map1.keySet()) {
            HashMap<String, Double> assignmentScoreMap = map1.get(ID);
            for (String name: assignmentScoreMap.keySet()) {
                if (!assignmentNames.contains(name)) {
                    assignmentNames.add(name);
                }
            }
        }
        Collections.sort(assignmentNames);
        return assignmentNames;
    }

    @Override
    public ArrayList<Integer> getSortedStudentIDs() {
        // Your code here (remove placeholder line below)
        ArrayList<Integer> IDList = new ArrayList<>(map1.keySet());
        Collections.sort(IDList);
        return IDList;
    }

    @Override
    public HashMap<String, Double> getStudentScores(Integer studentID) {
        // Your code here (remove placeholder line below)
        HashMap<String, Double> studentScores = map1.get(studentID);
        if (studentScores == null) {
            return new HashMap<>();
        } else {
            return studentScores;
        }
    }

    @Override
    public void setScore(String assignmentName, Integer studentID, Double score) {
        HashMap<String, Double> map2 = map1.get(studentID);
        if (map2 == null) {
            HashMap<String, Double> newMap = new HashMap<>();
            newMap.put(assignmentName, score);
            map1.put(studentID, newMap);
        } else {
            map2.put(assignmentName, score);
        }
    }

    public double getScore(String assignmentName, Integer studentID) {
        if (map1.containsKey(studentID)) {
            if (map1.get(studentID).containsKey(assignmentName)) {
                return map1.get(studentID).get(assignmentName);
            }
        }
        return Double.NaN;
    }
}