import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String map =
                "XXXXXXXXXXXXXX\n" +
                        "XXC1212121213X\n" +
                        "X4X21212O2121X\n" +
                        "X44X232323232X\n" +
                        "X444X43434343X\n" +
                        "X4444XXXXXX77X\n" +
                        "X4444O6789X99X\n" +
                        "XXXXXXXXXXXXXX";

        int time = 20;

        Pacman pacman = new Pacman(map);
        int maximumPacgums = pacman.getMaximumPacgums(time);
        System.out.println(maximumPacgums);
    }
}

class Pacman {
    private Node current;

    public Pacman(String map) {
        MapParser mp = new MapParser();
        current = mp.parse(map);
    }

    public int getMaximumPacgums(int time) {
        return getMaximumPoints(current, time);
    }

    private Integer getMaximumPoints(Node node, int time) {
        return getMaximumPoints(node, time, true);
    }

    private Integer getMaximumPoints(Node node, int time, boolean allowWrap) {
        if (node == null || time < 0 || node.getValue() == -3) {
            return 0;
        }

        int lock = node.getValue();

        node.setValue(-3);

        List<Integer> list = new ArrayList<>();

        list.add(getMaximumPoints(node.getUp(), time - 1));
        list.add(getMaximumPoints(node.getLeft(), time - 1));
        list.add(getMaximumPoints(node.getRight(), time - 1));
        list.add(getMaximumPoints(node.getDown(), time - 1));
        if (allowWrap) {
            list.add(getMaximumPoints(node.getWrap(), time, false));
        }

        node.setValue(lock);

        int currentValue = (node != this.current) ? node.getValue() : 0;

        return Collections.max(list) + currentValue;
    }
}

class MapParser {
    private static final int C = -1;
    private static final int X = -2;
    private static final int O = 0;

    public Node parse(String map) {
        return parseNodes(map);
    }

    private Node parseNodes(String map) {
        return parseNodes(parseMap(map));
    }

    private Node parseNodes(String[][] mapArr) {
        Node[][] mapNodes = new Node[mapArr.length][mapArr[0].length];
        Node wrap = null;

        for (int i = 0; i < mapArr.length; i++) {
            for (int j = 0; j < mapArr[i].length; j++) {
                int nodeValue = getValue(mapArr[i][j]);
                if (nodeValue != X) {
                    Node node = new Node();
                    node.setValue(nodeValue);

                    if (node.getValue() == O) {
                        if (wrap == null) {
                            wrap = node;
                        } else {
                            wrap.setWrap(node);
                            node.setWrap(wrap);
                        }
                    }

                    mapNodes[i][j] = node;
                } else {
                    mapNodes[i][j] = null;
                }
            }
        }

        return parseNodes(mapNodes);
    }

    private Node parseNodes(Node[][] mapArr) {
        Node current = null;
        for (int i = 0; i < mapArr.length; i++) {
            for (int j = 0; j < mapArr[i].length; j++) {
                Node node = mapArr[i][j];
                if (node != null) {
                    node.setUp(getUpNode(mapArr, i, j));
                    node.setDown(getDownNode(mapArr, i, j));
                    node.setLeft(getLeftNode(mapArr, i, j));
                    node.setRight(getRightNode(mapArr, i, j));

                    if (node.getValue() == C) {
                        current = node;
                    }
                }
            }
        }

        return current;
    }

    private Node getNode(Node[][] mapArr, int i, int j) {
        if (!valideBounds(mapArr, i, j)) {
            return null;
        }
        return mapArr[i][j];
    }

    private Node getRightNode(Node[][] mapArr, int i, int j) {
        return getNode(mapArr, i, j + 1);
    }

    private Node getLeftNode(Node[][] mapArr, int i, int j) {
        return getNode(mapArr, i, j - 1);
    }

    private Node getDownNode(Node[][] mapArr, int i, int j) {
        return getNode(mapArr, i + 1, j);
    }

    private Node getUpNode(Node[][] mapArr, int i, int j) {
        return getNode(mapArr, i - 1, j);
    }

    private boolean valideBounds(Node[][] mapArr, int i, int j) {
        return !(i < 0 || i >= mapArr.length || j < 0 || j >= mapArr[i].length);
    }

    private int getValue(String value) {
        switch (value) {
            case "C":
                return C;
            case "O":
                return O;
            case "X":
                return X;
            default:
                return Integer.parseInt(value);
        }
    }

    private String[][] parseMap(String map) {
        String[] rows = map.split("\n");

        String[][] mapArr = new String[rows.length][];

        for (int i = 0; i < rows.length; i++) {
            String row = rows[i];
            mapArr[i] = row.split("");
        }

        return mapArr;
    }
}

class Node {
    private Node up = null, down = null, left = null, right = null, wrap = null;
    private int value;

    public Node() {
    }

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
}