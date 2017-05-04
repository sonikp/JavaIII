package assgnINVobsvr;


public interface InventoryStoreOperations {
	void getItems() throws Exception;
	void getItem(String itemNum) throws Exception;
	void addItem(String itemType, String title, String artist, String productCode, String quantity) throws Exception;
	void editItem(String itemType, String artist) throws Exception;
	void deleteItem() throws Exception;
}