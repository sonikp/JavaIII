package zTBDassignment3module3BKUP1;


public interface InventoryProgramStoreOperations {
	void getItems() throws Exception;
	void getItem(String itemNum) throws Exception;
	void addItem(String itemType, String title, String artist, String productCode, String quantity) throws Exception;
	void editItem(String itemNum, String artist) throws Exception;
	void deleteItem(String itemNum) throws Exception;
}