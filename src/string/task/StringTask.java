package string.task;

public class StringTask implements Runnable{
    private int count;
    private String word;
    private StringTaskStates state;
    private Thread thread;
    private String result;

    public StringTask(String word, int count) {
        this.count = count;
        this.word = word;
        thread = new Thread(this);
        state = StringTaskStates.CREATED;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            if(thread.isInterrupted()){
                break;
            }
            result += word;
        }
        state = StringTaskStates.READY;
    }

    public int getCount() {
        return count;
    }

    public String getWord() {
        return word;
    }

    public StringTaskStates getState() {
        return state;
    }

    public String getResult() {
        return result;
    }

    public void start(){
        thread.start();
        state = StringTaskStates.RUNNING;
    }

    public void abort(){
        thread.interrupt();
        state = StringTaskStates.ABORTED;
    }

    public boolean isDone(){
        return getState().equals(StringTaskStates.READY) || getState().equals(StringTaskStates.ABORTED);
    }

}
