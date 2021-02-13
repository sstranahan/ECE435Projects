package JSON_APIS_ETC;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) throws JSONException {
        String jsonStr = "{" + "\"one\": 100.0, " +
                        "\"two\": [10, 20, 30], " +
                        "\"three\":{\"red\": 255, \"blue\": 26}" +
                        "}";

        JSONObject myJsonObject = new JSONObject(jsonStr);

        Double myNum;

        myNum = myJsonObject.getDouble("one");

        System.out.println();

        System.out.println("One: ");
        System.out.println(myNum);

        JSONArray myJSONArr = new JSONArray();

        myJSONArr = myJsonObject.getJSONArray("two");

        System.out.println();

        System.out.println("Two: ");

        for (int i = 0; i < 3; i++) {
            System.out.print(myJSONArr.get(i) + "\t");
        }

        System.out.println();
        System.out.println();

        JSONObject myJSONObject2 = new JSONObject();
        myJSONObject2 = myJsonObject.getJSONObject("three");

        int r, b = 0;

        r = myJSONObject2.getInt("red");
        b = myJSONObject2.getInt("blue");

        System.out.println("Red: ");
        System.out.println(r);
        System.out.println();

        System.out.println("Blue: ");
        System.out.println(b);
        System.out.println();




    }
}
