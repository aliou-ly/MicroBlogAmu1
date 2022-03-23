package requests.headers;

public abstract class AbstractHeader implements Headers {
    protected String code;

    protected AbstractHeader(String code) {this.code = code;}
    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return getCode();
    }
}
