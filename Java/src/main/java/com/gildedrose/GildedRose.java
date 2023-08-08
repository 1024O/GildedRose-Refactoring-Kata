package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equals("Aged Brie") ||
                    items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                ab_q(i);

            } else if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                if (items[i].quality > 0) {

                    t1(i);
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (items[i].name.equals("Aged Brie")) {
                    if (items[i].quality < 50) {
                        t(i);
                    }

                } else {
                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {

                        items[i].quality = 0;
                    } else {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                t1(i);
                            }
                        }
                    }
                }
            }
        }
    }

    private void ab_q(int i) {
        if (items[i].quality < 50) {
            t(i);
            if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].sellIn < 6) {
                    t(i);
                    t(i);
                } else if (items[i].sellIn < 11) {
                    t(i);
                }
            }
        }
    }

    private void t1(int i) {
        items[i].quality = items[i].quality - 1;

    }

    private void t(int i) {

        items[i].quality = items[i].quality + 1;
    }
}
