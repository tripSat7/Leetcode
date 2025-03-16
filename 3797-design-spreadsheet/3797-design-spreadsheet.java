class Spreadsheet {
    int sheet[][];
    public Spreadsheet(int rows) {
        sheet = new int[rows + 1][27];
    }
    
    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1));
        sheet[row][col] = value;
    }
    
    public void resetCell(String cell) {
        setCell(cell, 0);
    }
    
    public int getValue(String formula) {
        String temp[] = formula.substring(1).split("\\+");
        int ans = 0;
        if((temp[0].charAt(0) >= 'A' && temp[0].charAt(0) <= 'Z')){
            int col = temp[0].charAt(0) - 'A';
            int row = Integer.parseInt(temp[0].substring(1));
            ans += sheet[row][col];
        }
        else{
            ans += Integer.parseInt(temp[0]);
        }

        
        if((temp[1].charAt(0) >= 'A' && temp[1].charAt(0) <= 'Z')){
            int col = temp[1].charAt(0) - 'A';
            int row = Integer.parseInt(temp[1].substring(1));
            ans += sheet[row][col];
        }
        else{
            ans += Integer.parseInt(temp[1]);
        }

        return ans;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */