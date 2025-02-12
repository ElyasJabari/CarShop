<template>
  <div class="cars-container">
    <CarShopNavbar/>
    <!-- Ansicht der Autokarten -->
    <CarShopCards :cars="cars" @openCar="openCar"/>

    <!-- Modal für Detailansicht -->
    <CarShopModal :selectedCar="selectedCar" @closeModal="closeModal" />

  </div>
</template>

<script>
import CarShopNavbar from "@/components/CarShopNavbar.vue";
import CarShopCards from "@/components/CarShopCards.vue"; 
import CarShopModal from "@/components/CarShopModal.vue"; 

export default {
  name: "CarsShop",
  components:{
    CarShopNavbar,
    CarShopCards,
    CarShopModal
  },
  data() {
    return {
      cars: [
        {
          id: 1,
          brand: "BMW",
          model: "BMW M3",
          image: require('@/assets/BMW_M3.jpg'),
          shortDescription: "Sportliche Mittelklasse-Limousine mit Hochleistungstechnik",
          fullDescription:
            "Der BMW M3 ist ein leistungsstarker Sportwagen, der sowohl für den Alltag als auch für die Rennstrecke konzipiert wurde. Mit einem kraftvollen Reihensechszylinder-Motor, einem agilen Fahrwerk und sportlichem Design gehört er zu den bekanntesten Performance-Fahrzeugen weltweit."
        },
        {
          id: 2,
          brand: "BMW",
          model: "BMW X5 M",
          image: require('@/assets/BMW_X5_M.jpg'),
          shortDescription: "Leistungsstarker SUV mit luxuriöser Ausstattung.",
          fullDescription:
            "Der BMW X5 M vereint die Kraft eines Sportwagens mit der Vielseitigkeit eines SUVs. Dank seines V8-Biturbo-Motors und Allradantriebs bietet er außergewöhnliche Fahrleistungen, während der Innenraum mit edlen Materialien und modernster Technik höchsten Komfort garantiert."
        },
        {
          id: 3,
          brand: "Mercedes-Benz",
          model: "Mercedes-AMG GT",
          image: require('@/assets/Mercedes_AMG_GT.jpg'),
          shortDescription: "Luxuriöses Hochleistungs-Coupé mit atemberaubendem Design.",
          fullDescription:
            "Der Mercedes-AMG GT ist ein Sportwagen mit V8-Biturbo-Motor, der für Dynamik und Eleganz steht. Sein Design kombiniert aerodynamische Perfektion mit einer luxuriösen Innenausstattung und modernster Technologie für ein einzigartiges Fahrerlebnis."
        },
        {
          id: 4,
          brand: "Mercedes-Benz",
          model: "Mercedes-Benz G63 AMG",
          image: require('@/assets/Mercedes_Benz_G63_AMG.jpg'),
          shortDescription: "Legendärer Offroad-SUV mit massiver Leistung.",
          fullDescription:
            "Der G63 AMG ist eine Ikone unter den Geländewagen. Mit einem 4,0-Liter-V8-Motor und über 580 PS kombiniert er rohen Offroad-Charakter mit Luxus. Die markante Karosserie und die hochwertige Innenausstattung machen ihn sowohl auf der Straße als auch im Gelände zum echten Hingucker."
        },
        {
          id: 5,
          brand: "Audi",
          model: "Audi RS6 Avant",
          image: require('@/assets/Audi_RS6_Avant.jpg'),
          shortDescription: "Sportlicher Kombi mit Rennsport-Performance.",
          fullDescription:
            "Der Audi RS6 Avant verbindet die Alltagstauglichkeit eines Kombis mit der Leistung eines Sportwagens. Sein V8-Biturbo-Motor liefert über 600 PS, während das Allradsystem Quattro für maximale Traktion sorgt. Eine luxuriöse Ausstattung und moderne Assistenzsysteme runden das Gesamtpaket ab."
        },
        {
          id: 6,
          brand: "Audi",
          model: "Audi R8 V10 Performance",
          image: require('@/assets/Audi_R8_V10_Performance.jpg'),
          shortDescription: "Supersportwagen mit atemberaubendem Sound.",
          fullDescription:
            "Der Audi R8 V10 Performance ist ein Mittelmotor-Sportwagen mit einem frei saugenden V10-Motor. Dank des Quattro-Allradantriebs bietet er extreme Performance und ein herausragendes Handling. Sein futuristisches Design und der unverkennbare Motorsound machen ihn zu einem der begehrtesten Sportwagen."
        },
        {
          id: 7,
          brand: "Porsche",
          model: "Porsche 911 Turbo S",
          image: require('@/assets/Porsche_911_Turbo_S.jpeg'),
          shortDescription: "Ikonischer Sportwagen mit überragender Leistung.",
          fullDescription:
            "Der Porsche 911 Turbo S ist eine Legende unter den Sportwagen. Mit seinem 3,8-Liter-Sechszylinder-Boxermotor und Allradantrieb bietet er eine beeindruckende Beschleunigung und herausragendes Handling. Sein zeitloses Design und die hochwertige Verarbeitung machen ihn zu einem der begehrtesten Sportwagen der Welt."
        },
        {
          id: 8,
          brand: "Porsche",
          model: "Porsche Cayenne Turbo GT",
          image: require('@/assets/Porsche_Cayenne_Turbo_GT.jpg'),
          shortDescription: "High-Performance-SUV mit Porsche-DNA.",
          fullDescription:
            "Der Porsche Cayenne Turbo GT ist ein leistungsstarker SUV, der Sportwagen-Feeling mit hoher Alltagstauglichkeit verbindet. Mit über 640 PS und einer exzellenten Fahrwerksabstimmung bietet er eine beeindruckende Fahrdynamik. Sein luxuriöses Interieur und moderne Technologien machen ihn zu einer perfekten Wahl für Performance-Enthusiasten mit Platzbedarf."
        },
        {
          id: 9,
          brand: "Tesla",
          model: "Tesla Model S Plaid",
          image: require('@/assets/Tesla_Model_S_Plaid.png'),
          shortDescription: "Elektrische Hochleistungs-Limousine mit futuristischer Technologie.",
          fullDescription:
            "Das Tesla Model S Plaid ist eine der schnellsten Serienlimousinen der Welt. Mit drei Elektromotoren und über 1.000 PS beschleunigt es in unter zwei Sekunden auf 100 km/h. Neben der extremen Leistung bietet es ein minimalistisches Innenraumdesign mit einem großen Touchscreen und modernster Autopilot-Technologie."
        },
        {
          id: 10,
          brand: "Tesla",
          model: "Tesla Model X Plaid",
          image: require('@/assets/Tesla_Model_X_Plaid.jpg'),
          shortDescription: "Leistungsstarker Elektro-SUV mit futuristischem Design.",
          fullDescription:
            "Das Tesla Model X Plaid ist ein vollelektrischer SUV mit Falcon-Wing-Türen und außergewöhnlicher Beschleunigung. Mit drei Elektromotoren und über 1.000 PS erreicht er Höchstgeschwindigkeiten, die mit Sportwagen mithalten können. Seine hochmodernen Assistenzsysteme und der riesige Innenraum bieten eine einzigartige Mischung aus Komfort und Leistung."
        },
      ],
      selectedCar: null, // Speichert das aktuell ausgewählte Auto
    };
  },
  methods: {
    openCar(car) {
      this.selectedCar = car;
    },
    closeModal() {
      this.selectedCar = null;
    },
  },
};
</script>

<style scoped>
</style>
