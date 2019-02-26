package SampleMapUsage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class sampleMapUsage {

    /*
    For this example, our use case will be a school records system.  We will have a list of student IDs and student Names,
    and will have to perform finds and adds for both of those fields.
     */

    Map<Integer, String> records;
    int currentRecordNumber;

    public sampleMapUsage() {
        records = new HashMap<>();
        currentRecordNumber = 0;
    }

    public void addStudent(String name) {
        records.put(currentRecordNumber, name);
        currentRecordNumber++;
    }

    public String getStudent(int id) {
        return records.get(id);     //will return a null if the ID does not map to anything
    }

    public Set<Integer> findStudents(String name) {
        Set<Integer> ids = new HashSet<>();

        for(int id: records.keySet()) {         //This is a foreach loop, very useful when dealing with maps, otherwise you have to get ugly things like iterators.
            if(records.get(id).equals(name)) {
                ids.add(id);
            }
        }
        return ids;

    }



}
