package vttp.batch5.paf.day23.repositories;

public class Queries {

    public static final String SQL_CREATE_PURCHASE_ORDER = """
        insert into purchase_orders(po_id, name, address, delivery_date)
            values (?, ?, ?, ?)
    """;

    public static final String SQL_CREATE_LINE_ITEM = """
        insert into line_items(name, quantity, unit_price, po_id)
            values (?, ?, ?, ?)
    """;

}
