<template>
  <div class="cars-container">
    <CarShopNavbar @show-favorites="setShowFavorites(true)" @show-all="setShowFavorites(false)" :showFavorites="showFavorites"/>

    <CarShopCards :cars="favoritCars" :favorites="favoritesList" @openCar="openCar" @toggle-favorite="toggleFavorite"/>

    <CarShopModal :selectedCar="selectedCar" :favorites="favoritesList" @closeModal="closeModal" @toggle-favorite="toggleFavorite"/>
  </div>
</template>

<script>
import carsData from "@/assets/Cars.json"
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
      cars: carsData.map(car => ({
        ...car,
        image: require(`@/assets/${car.image}`)
      })),
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
};
</script>

<style scoped>
</style>
