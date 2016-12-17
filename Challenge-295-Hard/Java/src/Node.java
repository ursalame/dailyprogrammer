class Node {
    private Node up = null, down = null, left = null, right = null, wrap = null;
    private int value;
    private boolean used;


    public Node getUp() {
        return up;
    }

    public void setUp(Node up) {
        this.up = up;
    }

    public Node getDown() {
        return down;
    }

    public void setDown(Node down) {
        this.down = down;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getWrap() {
        return wrap;
    }

    public void setWrap(Node wrap) {
        this.wrap = wrap;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isUsed() {
        return used;
    }

    public void toggleUsed(){
        this.used = !this.used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
}