<template>
  <div class="cars-container">
    <CarShopNavbar @show-favorites="setShowFavorites(true)" @show-all="setShowFavorites(false)" :showFavorites="showFavorites"/>

    <CarShopCards :cars="favoritCars" :favorites="favoritesList" @openCar="openCar" @toggle-favorite="toggleFavorite"/>

    <CarShopModal :selectedCar="selectedCar" :favorites="favoritesList" @closeModal="closeModal" @toggle-favorite="toggleFavorite"/>
  </div>
</template>

<script>
import axios from "axios"; // Axios für HTTP-Anfragen
import CarShopNavbar from "@/components/CarShopNavbar.vue";
import CarShopCards from "@/components/CarShopCards.vue"; 
import CarShopModal from "@/components/CarShopModal.vue"; 

export default {
  name: "CarsShop",
  components: {
    CarShopNavbar,
    CarShopCards,
    CarShopModal
  },
  data() {
    return {
      cars: [],
      selectedCar: null,
      favoritesList: [],
      showFavorites: false
    };
  },
  computed: {
    favoritCars() {
      if (this.showFavorites) {
        return this.cars.filter(car => this.favoritesList.includes(car.id));
      }
      return this.cars;
    }
  },
  methods: {
    async fetchCars() {
      try {
        const response = await axios.get("http://localhost:9090/cars"); // Backend API-Endpoint
        this.cars = response.data.map(car => ({
          ...car,
          image: require(`@/assets/${car.image}`)
        }));
      } catch (error) {
        console.error("Fehler beim Laden der Autos:", error);
      }
    },
    openCar(car) {
      this.selectedCar = car;
    },
    closeModal() {
      this.selectedCar = null;
    },
    toggleFavorite(carId) {
      const index = this.favoritesList.indexOf(carId);
      if (index === -1) {
        this.favoritesList.push(carId);
      } else {
        this.favoritesList.splice(index, 1);
      }
    },
    setShowFavorites(value) {
      this.showFavorites = value;
    },
  },
  mounted() {
    this.fetchCars(); // Daten beim Laden der Seite abrufen
  }
};
</script>
