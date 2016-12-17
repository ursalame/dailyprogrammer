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