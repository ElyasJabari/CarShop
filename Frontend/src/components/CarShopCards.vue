<template>
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
      <img :src="car.image" :alt="car.name" class="car-image" />
      <div class="car-info">
        <h3 class="car-title">{{ car.model }}</h3>
        <p class="car-desc">{{ car.shortDescription }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "CarShopCards",
  props: {
    cars: Array,
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


/* Cards */
.cars-container {
  background-color: #f5f7fa;
  min-height: 100vh;
  padding-bottom: 2rem;
}

.cars-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 1.5rem;
  margin: 2rem auto 0;
  max-width: 1200px;
}

.car-card {
  background-color: #ffffff;
  border-radius: 8px;
  overflow: hidden;
  box-shadow: 0 2px 8px rgba(0,0,0,0.1);
  cursor: pointer;
  transition: transform 0.2s ease, box-shadow 0.2s ease;
}

.car-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 4px 12px rgba(0,0,0,0.15);
}

.car-image {
  width: 100%;
  height: 160px;
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