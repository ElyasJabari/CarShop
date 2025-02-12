<template>
    <transition name="fade">
      <div v-if="selectedCar" class="modal" @click.self="$emit('closeModal')">
        <div class="modal-content">
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
      selectedCar: Object, // Erwartet das ausgewählte Auto
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
  top: 0.5rem;
  right: 0.5rem;
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