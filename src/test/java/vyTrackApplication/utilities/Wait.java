package vyTrackApplication.utilities;

public class Wait {

    public static void waitPlease(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
