<template>
  <div class="CarShopCards">
    <div class="filter-container">
      <label class="filter-title">Filter nach:</label>
      <div class="filter-group">
        <label for="brand-select">Modell:</label>
        <select id="brand-select" v-model="selectedBrand">
          <option value="">Alle</option>
          <option v-for="brand in uniqueBrands" :key="brand" :value="brand">{{ brand }}</option>
        </select>
      </div>
    </div>

    <div class="cars-grid">
      <div class="car-card" v-for="car in filteredCars" :key="car.id" @click="openCar(car)">
        <button class="favorite-button" @click.stop="$emit('toggle-favorite', car.id)">
          <svg :class="{ favorited: favorites.includes(car.id) }" viewBox="0 0 24 24">
            <path d="M12 21.35l-1.45-1.32C5.4 15.36 2 12.28 2 8.5 2 5.42 4.42 3 7.5 3c1.74 0 3.41.81 4.5 2.09C13.09 3.81 14.76 3 16.5 3 19.58 3 22 5.42 22 8.5c0 3.78-3.4 6.86-8.55 11.54L12 21.35z"/>
          </svg>
        </button>
        <img :src="car.image" :alt="car.name" class="car-image" />
        <div class="car-info">
          <h3 class="car-title">{{ car.model }}</h3>
          <p class="car-desc">{{ car.shortDescription }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "CarShopCards",
  props: {
    cars: Array,
    favorites: Array,
  },
  data() {
    return {
      selectedBrand: "" // Speichert die ausgewählte Marke
    };
  },
  computed: {
    // Einzigartige Automarken für das Dropdown
    uniqueBrands() {
      return [...new Set(this.cars.map(car => car.brand))];
    },
    // Gefilterte Autos basierend auf der ausgewählten Marke
    filteredCars() {
      if (!this.selectedBrand) {
        return this.cars;
      }
      return this.cars.filter(car => car.brand === this.selectedBrand);
    }
  },
  methods: {
    openCar(car) {
      this.$emit("openCar", car); 
    },
  },
};
</script>

<style scoped>
/* Filter */
.filter-container {
  background-color: #ffffff;
  border: 1px solid #e0e0e0;
  border-radius: 8px;
  padding: 0.3rem 1.5rem;
  margin: 1.5rem auto 0;
  max-width: 1150px;
  display: flex;
  flex-wrap: wrap;
  align-items: center;
  gap: 1rem;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
}

.filter-title {
  font-size: 1.2rem;
  font-weight: bold;
  color: #333;
  margin-right: auto;
}

.filter-group {
  display: flex;
  align-items: center;
  gap: 0.5rem;
}

.filter-group label {
  font-size: 1rem;
  color: #555;
}

.filter-group select {
  padding: 0.2rem 1rem;
  border: 1px solid #ccc;
  border-radius: 8px;
  font-size: 1rem;
  transition: border-color 0.2s ease;
}

.filter-group select:focus {
  border-color: #007BFF;
  outline: none;
}

/* Favorites */
.favorite-button {
  position: absolute;
  top: 5px;
  right: 5px;
  background: rgba(155, 154, 154, 0.7); /* Leichter Hintergrund */
  border: none;
  cursor: pointer;
  padding: 8px;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  transition: background 0.2s ease, transform 0.2s ease;
  z-index: 10;
}

.favorite-button svg {
  width: 24px;
  height: 24px;
  fill: #e2e1e1;
  transition: fill 0.2s;
}

.favorite-button .favorited {
  fill: red;
}

/* Cards */
.cars-container {
  background-color: #f5f7fa;
  min-height: 100vh;
  padding-bottom: 2rem;
}

.cars-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  gap: 1.5rem;
  margin: 2rem auto 0;
  max-width: 1200px;
  justify-content: center;
  padding: 0 1rem;
}

.cars-grid .car-card:only-child {
  max-width: 400px;
  margin: 0 auto;
}

.car-card {
  background-color: #ffffff;
  border-radius: 12px;
  overflow: hidden;
  box-shadow: 0 4px 12px rgba(0,0,0,0.3);
  cursor: pointer;
  transition: transform 0.3s ease, box-shadow 0.3s ease;
  position: relative;
}

.car-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 4px 12px rgba(0,0,0,0.15);
}

/* Bild mit 16:9-Seitenverhältnis */
.car-image {
  width: 100%;
  aspect-ratio: 16 / 9;
  object-fit: cover;
}

.car-info {
  padding: 1rem;
}

.car-title {
  margin: 0;
  font-size: 1.25rem;
  color: #333;
}

.car-desc {
  margin: 0.5rem 0 0;
  font-size: 0.9rem;
  color: #666;
}
</style>