package ricardo.ale.fragmentmanager;

public interface IFragmentCallback {

    void sendMsgToActivity(String msg);

    String getMsgFromActivity(String msg);

}
