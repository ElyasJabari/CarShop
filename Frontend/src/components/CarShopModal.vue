<template>
    <transition name="fade">
      <div v-if="selectedCar" class="modal" @click.self="$emit('closeModal')">
        <div class="modal-content">
          <button class="favorite-button" @click.stop="$emit('toggle-favorite', selectedCar.id)">
            <svg :class="{ favorited: favorites.includes(selectedCar.id) }" viewBox="0 0 24 24">
              <path d="M12 21.35l-1.45-1.32C5.4 15.36 2 12.28 2 8.5 2 5.42 4.42 3 7.5 3c1.74 0 3.41.81 4.5 2.09C13.09 3.81 14.76 3 16.5 3 19.58 3 22 5.42 22 8.5c0 3.78-3.4 6.86-8.55 11.54L12 21.35z"/>
            </svg>
          </button>
          <button class="modal-close" @click="$emit('closeModal')">&times;</button>
          <img :src="selectedCar.image" :alt="selectedCar.name" class="modal-image" />
          <h2 class="modal-title">{{ selectedCar.model }}</h2>
          <p class="modal-description">{{ selectedCar.fullDescription }}</p>
        </div>
      </div>
    </transition>
  </template>
  
  <script>
  export default {
    name: "CarShopModal",
    props: {
      selectedCar: Object,
      favorites: Array,
    },
  };
  </script>
  

<style scoped>
.modal {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: rgba(0,0,0,0.5);
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 1000;
}

.modal-content {
  background: #fff;
  border-radius: 8px;
  padding: 2rem;
  width: 90%;
  max-width: 600px;
  position: relative;
  text-align: center;
}


.favorite-button {
  position: absolute;
  top: 5px;
  left: 5px;
  background: rgba(0, 0, 0, 0.1);
  border: none;
  cursor: pointer;
  padding: 8px;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  transition: background 0.2s ease, transform 0.2s ease;
  z-index: 1000;
}

.favorite-button svg {
  width: 32px;
  height: 32px;
  fill: #ccc;
  transition: fill 0.2s;
}

.favorite-button:hover {
  background: rgba(0, 0, 0, 0.3);
}

.favorite-button .favorited {
  fill: red;
}

.modal-close {
  position: absolute;
  top: 1rem;
  right: 1rem;
  border: none;
  background: none;
  font-size: 1.5rem;
  cursor: pointer;
  color: #333;
}

.modal-image {
  width: 100%;
  height: 300px;
  object-fit: cover;
  border-radius: 4px;
  margin-bottom: 1rem;
}

.modal-title {
  font-size: 1.8rem;
  margin: 0.5rem 0;
  color: #222;
}

.modal-description {
  font-size: 1rem;
  color: #555;
}

.modal-close {
  position: absolute;
  top: 5px;
  right: 5px;
  width: 40px;
  height: 40px;
  border: none;
  background: rgba(0, 0, 0, 0.1);
  font-size: 1.5rem;
  cursor: pointer;
  color: #333;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 50%;
}

.modal-close:hover {
  background: rgba(0, 0, 0, 0.3);
  color: white;
}
/* Transition für das Modal (Fade-In/Fade-Out) */
.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.3s ease;
}
.fade-enter,
.fade-leave-to {
  opacity: 0;
}
</style>