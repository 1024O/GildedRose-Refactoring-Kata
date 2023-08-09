package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }
            int offset = 0;
            items[i].sellIn = items[i].sellIn - 1;
            switch (items[i].name) {
                case "Aged Brie":
                    offset += 1;
                    if(items[i].sellIn < 0) {
                        offset += 1;
                    }
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    if (items[i].sellIn < 0) {
                        offset -= items[i].quality;
                        break;
                    }
                    offset += 1;
                    if (items[i].sellIn < 6 - 1) {
                        offset += 1;
                    }
                    if (items[i].sellIn < 11 - 1) {
                        offset += 1;
                    }
                    break;
                case "Conjured":
                    offset -= 1;
                    if(items[i].sellIn < 0) {
                        offset -= 1;
                    }
                default:
                    offset -= 1;
                    if(items[i].sellIn < 0) {
                        offset -= 1;
                    }
            }
            normal(items[i],offset);
            check(items[i]);
        }
    }

    // 每种物品的品质不会超过50，然而"Sulfuras"（萨弗拉斯—炎魔拉格纳罗斯之手）是一个传奇物品，因此它的品质是80且永远不变
    private void check(Item item) {
        if (item.quality > 50) {
            item.quality = 50;

        }
        if (item.quality < 0) {
            item.quality = 0;
        }
    }

    private void normal(Item item, int offset) {
        item.quality += offset;
    }

}
