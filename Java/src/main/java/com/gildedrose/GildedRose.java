package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if(items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }
            items[i].sellIn = items[i].sellIn - 1;
            switch (items[i].name) {
                case "Aged Brie":
                    if (items[i].quality < 50) {
                        t(i);
                        if (items[i].sellIn < 0) {
                            t(i);
                        }
                    }
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    if (items[i].sellIn < 0) {
                        items[i].quality = 0;
                        break;
                    }
                    if (items[i].quality < 50) {
                        t(i);
                        if (items[i].sellIn < 6 - 1) {
                            t(i);
                        }
                        if (items[i].sellIn < 11 - 1) {
                            t(i);
                        }
                    }
                    break;
                default:
                    t1(i);
                    if (items[i].sellIn < 0) {
                        t1(i);
                    }
            }
            if (items[i].quality > 50) {
                items[i].quality = 50;

            }
            if (items[i].quality < 0) {
                items[i].quality = 0;

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
