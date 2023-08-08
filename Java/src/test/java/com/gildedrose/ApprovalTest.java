package com.gildedrose;

import org.approvaltests.Approvals;
import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

class ApprovalTest {

    @Test
    public void foo() {
        CombinationApprovals.verifyAllCombinations(
            this::it,
            new String[]{"Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros", "item"},
            new Integer[]{1,6,8,67,-1},
            new Integer[]{47,67,98,17,-1}
        );
    }

    private String it(String name,int sellIn, int quality) {
        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        return gildedRose.items[0].toString();
    }
}
