package requests.headers;

public class SubscribeHeaderToTag extends AbstractSubscribeHeader {
    private String tag;

    public SubscribeHeaderToTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return super.toString()
                .concat(" tag:"+tag);
    }
}
