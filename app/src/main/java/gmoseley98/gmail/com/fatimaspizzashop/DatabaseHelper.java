package gmoseley98.gmail.com.fatimaspizzashop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "pizzaShop.db";

    /*
    public static final String TOPPING_TABLE = "Toppings";
    public static final String TOPPING_ID = "id";
    public static final String TOPPING_NAME = "name";
    public static final String TOPPING_PRICE = "price";
     */

    public static final String ORDER_TABLE = "Orders";
    public static final String ORDER_ID = "order_id";
    public static final String MENU_ID = "menu_id";
    public static final String CUSTOMER_ID_ORDER = "customer_id";
    public static final String PAY_AMOUNT = "total";
    public static final String PAY_TYPE = "payment_type";
    public static final String QUANTITY = "quantity";

    public static final String CUSTOMER_TABLE = "Customer";
    public static final String CUSTOMER_ID = "customer_id";
    public static final String CUSTOMER_NAME = "name";
    public static final String ADDRESS = "address";
    public static final String PHONE_NUM = "phone";

    public static final String ORDER_TYPE_TABLE = "Order_Type";
    public static final String ORDER_TYPE = "order_type";
    public static final String ORDER_TYPE_ID = "order_id";
    public static final String CUSTOMER_ID_ORDER_TYPE = "customer_id";

    public static final String PIZZA_MENU_TABLE = "Pizza_Menu";
    public static final String PIZZA_MENU_ID = "menu_id";
    public static final String PIZZA_TYPE = "type";
    public static final String PIZZA_SIZE = "size";
    public static final String PIZZA_PRICE = "price";
    public static final String MENU_TOPPING_ID = "topping_id";

    public static final String CREDIT_CARD_TABLE = "Credit_Card";
    public static final String CUSTOMER_ID_CARD = "customer_id";
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

       /*
        db.execSQL("CREATE TABLE " + TOPPING_TABLE + "("
                + TOPPING_ID + " INTEGER PRIMARY KEY, "
                + TOPPING_NAME + " TEXT, "
                + TOPPING_PRICE + " VARCHAR )");
        */

        db.execSQL("CREATE TABLE " + ORDER_TABLE + " ("
                + ORDER_ID + " TEXT PRIMARY KEY, "
                + MENU_ID + " TEXT, "
                + CUSTOMER_ID_ORDER + " TEXT, "
                + PAY_AMOUNT + " VARCHAR, "
                + PAY_TYPE + " TEXT, "
                + QUANTITY + " TEXT ) ");

        db.execSQL("CREATE TABLE " + CUSTOMER_TABLE + " ("
                + CUSTOMER_ID + " INTEGER PRIMARY KEY, "
                + CUSTOMER_NAME + " TEXT,"
                + ADDRESS + " VARCHAR, "
                + PHONE_NUM + " VARCHAR ) ");

        db.execSQL("CREATE TABLE " + ORDER_TYPE_TABLE + " ("
                + ORDER_TYPE + " TEXT, "
                + ORDER_TYPE_ID + " INTEGER, "
                + CUSTOMER_ID_ORDER_TYPE + " INTEGER )");

        db.execSQL("CREATE TABLE " + PIZZA_MENU_TABLE + " ("
                + PIZZA_MENU_ID + " INTEGER PRIMARY KEY, "
                + PIZZA_TYPE + " TEXT,"
                + PIZZA_SIZE + " TEXT, "
                + PIZZA_PRICE + " VARCHAR, "
                + MENU_TOPPING_ID + " INTEGER )");

        db.execSQL("CREATE TABLE " + CREDIT_CARD_TABLE + " ("
                + CUSTOMER_ID_CARD + " INTEGER, "
                + CARD_NUMBER + " INTEGER,"
                + NAME_ON_CARD + " TEXT,"
                + EXP_DATE + " VARCHAR, "
                + SECURITY_NUM + " INTEGER )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS " + ORDER_TYPE_TABLE);
        onCreate(db);

    }

    // Inserting methods



}
