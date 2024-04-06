package hexlet.code.formatters.Json;

import java.util.Map;

public class JsonObject {

    private Map valueOfKeyDoesntChange;
    private Map valueOfKeyWasChanged;
    private Map keyWasDeleted;
    private Map keyWasAdded;


    public Map getValueOfKeyDoesntChange() {
        return valueOfKeyDoesntChange;
    }

    public void setValueOfKeyDoesntChange(Map valueOfKeyDoesntChange) {
        this.valueOfKeyDoesntChange = valueOfKeyDoesntChange;
    }

    public Map getValueOfKeyWasChanged() {
        return valueOfKeyWasChanged;
    }

    public void setValueOfKeyWasChanged(Map valueOfKeyWasChanged) {
        this.valueOfKeyWasChanged = valueOfKeyWasChanged;
    }

    public Map getKeyWasDeleted() {
        return keyWasDeleted;
    }

    public void setKeyWasDeleted(Map keyWasDeleted) {
        this.keyWasDeleted = keyWasDeleted;
    }

    public Map getKeyWasAdded() {
        return keyWasAdded;
    }

    public void setKeyWasAdded(Map keyWasAdded) {
        this.keyWasAdded = keyWasAdded;
    }
//    public JsonObject objWithoutNull(){
//
//        if(this.getValueOfKeyDoesntChange().equals(null))
//    }
}
