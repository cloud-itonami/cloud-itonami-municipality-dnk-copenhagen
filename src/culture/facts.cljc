(ns culture.facts
  "Regional-culture catalog for Copenhagen -- local dishes,
  protected products, beverages, festivals and heritage sites, piggybacked
  onto this municipality compliance repo per ADR-2607171400
  (cloud-itonami-municipality-culture-catalog, in com-junkawasaki/root),
  sibling namespace to `ordinance.facts` (ADR-2607141700).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "municipality-slug -> vector of culture entries."
  {"copenhagen"
   [{:culture/id "copenhagen.dish.smoerrebroed"
     :culture/name "Smørrebrød"
     :culture/municipality "copenhagen"
     :culture/country "DNK"
     :culture/kind :dish
     :culture/summary "Traditional open-faced sandwich of buttered rye bread with toppings such as cold cuts, fish and cheese, in the cuisines of Denmark, Norway and Sweden; a Danish staple rather than Copenhagen-specific."
     :culture/url "https://en.wikipedia.org/wiki/Sm%C3%B8rrebr%C3%B8d"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "copenhagen.dish.stegt-flaesk"
     :culture/name "Stegt flæsk"
     :culture/municipality "copenhagen"
     :culture/country "DNK"
     :culture/kind :dish
     :culture/summary "Fried pork belly generally served with potatoes and parsley sauce; the national dish of Denmark."
     :culture/url "https://en.wikipedia.org/wiki/Stegt_fl%C3%A6sk"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "copenhagen.dish.danish-pastry"
     :culture/name "Danish pastry"
     :culture/name-local "Wienerbrød"
     :culture/municipality "copenhagen"
     :culture/country "DNK"
     :culture/kind :dish
     :culture/summary "Layered pastry known in Danish as wienerbrød; its bakery techniques were brought to Denmark by Austrian bakers around 1850, and it is national rather than Copenhagen-specific."
     :culture/url "https://en.wikipedia.org/wiki/Danish_pastry"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "copenhagen.dish.roed-poelse"
     :culture/name "Rød pølse"
     :culture/municipality "copenhagen"
     :culture/country "DNK"
     :culture/kind :dish
     :culture/summary "Brightly red boiled pork sausage very common in Denmark, with strong cultural ties to the Danish hot dog stands found almost everywhere in the country."
     :culture/url "https://en.wikipedia.org/wiki/R%C3%B8d_p%C3%B8lse"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "copenhagen.beverage.carlsberg"
     :culture/name "Carlsberg"
     :culture/municipality "copenhagen"
     :culture/country "DNK"
     :culture/kind :beverage
     :culture/summary "Beer from the brewer Carlsberg, founded in 1847 by J. C. Jacobsen and headquartered in Copenhagen."
     :culture/url "https://en.wikipedia.org/wiki/Carlsberg_Group"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "copenhagen.craft.royal-copenhagen"
     :culture/name "Royal Copenhagen porcelain"
     :culture/municipality "copenhagen"
     :culture/country "DNK"
     :culture/kind :craft
     :culture/summary "Porcelain from Royal Copenhagen, officially the Royal Porcelain Factory, a Danish manufacturer founded in Copenhagen in 1775."
     :culture/url "https://en.wikipedia.org/wiki/Royal_Copenhagen"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "copenhagen.festival.copenhagen-jazz-festival"
     :culture/name "Copenhagen Jazz Festival"
     :culture/municipality "copenhagen"
     :culture/country "DNK"
     :culture/kind :festival
     :culture/summary "Annual jazz festival held in Copenhagen since 1979, one of the largest music events in Europe with over 1,100 concerts."
     :culture/url "https://en.wikipedia.org/wiki/Copenhagen_Jazz_Festival"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "copenhagen.heritage.tivoli-gardens"
     :culture/name "Tivoli Gardens"
     :culture/name-local "Tivoli"
     :culture/municipality "copenhagen"
     :culture/country "DNK"
     :culture/kind :heritage
     :culture/summary "Amusement park in Copenhagen opened on 15 August 1843, the second-oldest operating amusement park in the world."
     :culture/url "https://en.wikipedia.org/wiki/Tivoli_Gardens"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "copenhagen.heritage.little-mermaid-statue"
     :culture/name "The Little Mermaid"
     :culture/name-local "Den lille Havfrue"
     :culture/municipality "copenhagen"
     :culture/country "DNK"
     :culture/kind :heritage
     :culture/summary "Bronze statue by Edvard Eriksen depicting a mermaid becoming human, displayed on a rock by the waterside at the Langelinie promenade in Copenhagen."
     :culture/url "https://en.wikipedia.org/wiki/The_Little_Mermaid_(statue)"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-dnk-copenhagen culture catalog "
                 "(ADR-2607171400): " (count (get catalog "copenhagen"))
                 " Copenhagen entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [muni kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis muni)))
