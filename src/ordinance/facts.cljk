(ns ordinance.facts
  "Municipal-ordinance compliance catalog for Copenhagen -- the
  FOURTEENTH municipality-level entry (see cloud-itonami-municipality-jpn-tokyo,
  -usa-washington-dc, -gbr-london, -can-toronto, -deu-berlin, -fra-paris,
  -nld-amsterdam, -esp-madrid, -kor-seoul, -ita-roma, -aus-sydney,
  -arg-buenos-aires, -fin-helsinki for the first thirteen) per
  ADR-2607141700 (cloud-itonami-compliance-fact-federation).

  Every entry cites an OFFICIAL kk.dk-family (City of Copenhagen) page
  or PDF -- never fabricated. An ordinance not in this table has NO
  spec-basis, full stop; extend `catalog`, do not invent an id/url/date.

  The commercial-waste regulation PDF (hosted on kk.sites.itera.dk, the
  municipality's own document-publishing subdomain) rendered as a
  strong tier-1 source: the cover page is fully legible with the exact
  title and effective date printed cleanly, unlike several other PDF
  sources hit elsewhere in this family. The governance-charter date
  comes directly from kk.dk's own 'Sådan styres København' page, which
  states the current charter is 'Styrelsesvedtægt for Københavns
  Kommune pr. 25. juni 2026' -- used as the charter's stated
  as-of/effective date, not an invented enactment date.")

(def catalog
  "municipality-slug -> vector of ordinance entries."
  {"copenhagen"
   [{:ordinance/id "copenhagen.regulativ-for-erhvervsaffald"
     :ordinance/title "Regulativ for Erhvervsaffald (Regulation for Commercial Waste)"
     :ordinance/municipality "copenhagen"
     :ordinance/country "DNK"
     :ordinance/kind :ordinance
     :ordinance/url "https://kk.sites.itera.dk/apps/kk_pub2/pdf/2830_263bb392c685.pdf"
     :ordinance/url-provenance :official-kk-dk
     :ordinance/enacted-date "2024-09-01"
     :ordinance/retrieved-at "2026-07-15"
     :ordinance/topic #{:waste-management :environment}}
    {:ordinance/id "copenhagen.styrelsesvedtaegt-governance-charter"
     :ordinance/title "Styrelsesvedtægt for Københavns Kommune (Governance Charter)"
     :ordinance/municipality "copenhagen"
     :ordinance/country "DNK"
     :ordinance/kind :ordinance
     :ordinance/url "https://www.kk.dk/politik/borgerrepraesentationen/saadan-styres-koebenhavn"
     :ordinance/url-provenance :official-kk-dk
     :ordinance/enacted-date "2026-06-25"
     :ordinance/retrieved-at "2026-07-15"
     :ordinance/topic #{:governance}}]})

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
      :note (str "cloud-itonami-municipality-dnk-copenhagen Wave 0 (ADR-2607141700): "
                 (count (get catalog "copenhagen")) " Copenhagen entries seeded "
                 "with an official kk.dk citation. "
                 "Extend `ordinance.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [muni topic]
  (filterv #(contains? (:ordinance/topic %) topic) (spec-basis muni)))
