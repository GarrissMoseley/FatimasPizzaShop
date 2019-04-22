package gmoseley98.gmail.com.fatimaspizzashop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "pizzaShop.db";

    public static final String ORDER_TABLE = "Orders";
//    public static final String ORDER_ID = "order_id";
//    public static final String MENU_ID = "menu_id";
//    public static final String CUSTOMER_ID_ORDER = "customer_id";
    public static final String PAY_AMOUNT = "total";
    public static final String PAY_TYPE = "payment_type";
    public static final String QUANTITY = "quantity";
    public static final String ORDER_TYPE = "order_type";

    public static final String CUSTOMER_TABLE = "Customer";
//    public static final String CUSTOMER_ID = "customer_id";
    public static final String CUSTOMER_NAME = "name";
    public static final String ADDRESS = "address";
    public static final String PHONE_NUM = "phone";

//    public static final String PIZZA_MENU_TABLE = "Pizza_Menu";
//    public static final String PIZZA_MENU_ID = "menu_id";
//    public static final String PIZZA_TYPE = "type";
//    public static final String PIZZA_SIZE = "size";
//    public static final String PIZZA_PRICE = "price";

    public static final String CREDIT_CARD_TABLE = "Credit_Card";
//    public static final String CUSTOMER_ID_CARD = "customer_id";
    public static final String CARD_NUMBER = "card_number";
    public static final String NAME_ON_CARD = "name_on_card";
    public static final String EXP_DATE = "expiration_date";
    public static final String SECURITY_NUM = "security_number";

    private Cursor cursor;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + ORDER_TABLE + " ("
//                + ORDER_ID + " TEXT PRIMARY KEY, "
//                + MENU_ID + " TEXT, "
//                + CUSTOMER_ID_ORDER + " TEXT, "
                + PAY_AMOUNT + " VARCHAR, "
                + PAY_TYPE + " TEXT, "
                + QUANTITY + " TEXT, " + ORDER_TYPE + " TEXT ) ");

        db.execSQL("CREATE TABLE " + CUSTOMER_TABLE + " ("
//                + CUSTOMER_ID + " INTEGER PRIMARY KEY, "
                + CUSTOMER_NAME + " TEXT,"
                + ADDRESS + " VARCHAR, "
                + PHONE_NUM + " VARCHAR ) ");


//        db.execSQL("CREATE TABLE " + PIZZA_MENU_TABLE + " ("
//                + PIZZA_MENU_ID + " INTEGER PRIMARY KEY, "
//                + PIZZA_TYPE + " TEXT,"
//                + PIZZA_SIZE + " TEXT, "
//                + PIZZA_PRICE + " VARCHAR )");

        db.execSQL("CREATE TABLE " + CREDIT_CARD_TABLE + " ("
//                + CUSTOMER_ID_CARD + " INTEGER, "
                + CARD_NUMBER + " INTEGER,"
                + NAME_ON_CARD + " TEXT,"
                + EXP_DATE + " VARCHAR, "
                + SECURITY_NUM + " INTEGER )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS " + ORDER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + CUSTOMER_TABLE);
//        db.execSQL("DROP TABLE IF EXISTS " + PIZZA_MENU_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + CREDIT_CARD_TABLE);
        onCreate(db);
    }

    public boolean insertOrderInfo(/*String orderId, String menuId, String customerId,*/
                                   String paymentAmount, String payType,
                                   String quantity, String orderType) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

//        contentValues.put(ORDER_ID, orderId);
//        contentValues.put(MENU_ID, menuId);
//        contentValues.put(CUSTOMER_ID_ORDER, customerId);
        contentValues.put(PAY_AMOUNT, paymentAmount);
        contentValues.put(PAY_TYPE, payType);
        contentValues.put(QUANTITY, quantity);
        contentValues.put(ORDER_TYPE, orderType);
        long result = db.insert(ORDER_TABLE, null, contentValues);
        return result != -1;
    }

    public boolean insertCustomerInfo(/*String customerId,*/ String customerName, String address,
                                      String phoneNum) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

//        contentValues.put(CUSTOMER_ID, customerId);
        contentValues.put(CUSTOMER_NAME, customerName);
        contentValues.put(ADDRESS, address);
        contentValues.put(PHONE_NUM, phoneNum);
        long result = db.insert(CUSTOMER_TABLE, null, contentValues);
        return result != -1;
    }

//    public boolean insertPizzaMenu(String menuId, String pizzaType, String pizzaSize, String pizzaPrice) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//
//        contentValues.put(PIZZA_MENU_ID, menuId);
//        contentValues.put(PIZZA_TYPE, pizzaType);
//        contentValues.put(PIZZA_SIZE, pizzaSize);
//        contentValues.put(PIZZA_PRICE, pizzaPrice);
//        long result = db.insert(PIZZA_MENU_TABLE, null, contentValues);
//        return result != -1;
//    }

    public boolean insertCreditInfo(/*String customerId,*/ String cardNum, String nameOnCard, String expDate,
                                    String securityNum) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

//        contentValues.put(CUSTOMER_ID_CARD, customerId);
        contentValues.put(CARD_NUMBER, cardNum);
        contentValues.put(NAME_ON_CARD, nameOnCard);
        contentValues.put(EXP_DATE, expDate);
        contentValues.put(SECURITY_NUM, securityNum);
        long result = db.insert(CREDIT_CARD_TABLE, null, contentValues);
        return result != -1;
    }

    public Cursor readOrders() {
        String[] columns = {ORDER_TYPE, PAY_AMOUNT};
        this.cursor = this.getReadableDatabase().query(ORDER_TABLE, columns, null, null,
                null, null, null);
        return cursor;
    }

//    public Cursor readCustomerInfo(String customerId) {
//        String[] columns = {CUSTOMER_NAME, ADDRESS, PHONE_NUM};
//        String whereClause = CUSTOMER_ID + "=?";
//        String[] whereArgs = new String[]{customerId};
//        this.cursor = this.getReadableDatabase().query(CUSTOMER_TABLE, columns, whereClause,
//                whereArgs, null, null, null);
//        return cursor;
//    }

//    public Cursor readPizzaMenu(String menuId) {
//        String[] columns = {PIZZA_MENU_TABLE, PIZZA_TYPE, PIZZA_SIZE, PIZZA_PRICE};
//        String whereClause = PIZZA_MENU_ID + "=?";
//        String[] whereArgs = new String[] {menuId};
//        this.cursor = this.getReadableDatabase().query(PIZZA_MENU_TABLE, columns, whereClause,
//                whereArgs, null, null, null);
//        return cursor;
//    }




}
