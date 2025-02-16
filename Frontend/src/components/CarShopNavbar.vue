<template>
  <div>
    <nav class="CarShopNavbar">
      <div class="nav-container">
        <div class="nav-logo">
          <a href="#">CarShop</a>
        </div>
        <!-- Hamburger Icon nur auf mobilen Geräten -->
        <div class="mobile-menu-icon" @click="toggleMenu">
          <span></span>
          <span></span>
          <span></span>
        </div>
        <!-- Navigation; im Mobile-Mode wird sie als Dropdown eingeblendet -->
        <ul class="nav-links" :class="{ 'mobile-open': isMenuOpen }">
          <li>
            <a href="#" @click.prevent="$emit('show-all'); closeMenu()" :class="{ active: !showFavorites }">
              Startseite
            </a>
          </li>
          <li>
            <a href="#" @click="closeMenu()">Über uns</a>
          </li>
          <li>
            <a href="#" @click="closeMenu()">Kontakt</a>
          </li>
          <li>
            <a href="#" @click.prevent="$emit('show-favorites'); closeMenu()" :class="{ active: showFavorites }">
              Favoriten
            </a>
          </li>
        </ul>
      </div>
    </nav>

    <!-- header-Bereich mit Hintergrundbild -->
    <section class="header">
      <div class="header-overlay"></div>
      <div class="header-content">
        <h1>Willkommen bei CarShop – Ihrem Online-Portal für Autos! 🚗✨</h1>
        <p>
          Entdecken Sie eine große Auswahl an Fahrzeugen mit allen wichtigen Details auf einen Blick.
        </p>
        <p>
          Klicken Sie auf ein Auto und erfahren Sie mehr über Ausstattung, Leistung und Besonderheiten.
        </p>
      </div>
    </section>
  </div>
</template>

<script>
export default {
  name: "CarShopNavbar",
  props: {
    showFavorites: Boolean
  },
  data() {
    return {
      isMenuOpen: false
    };
  },
  methods: {
    toggleMenu() {
      this.isMenuOpen = !this.isMenuOpen;
    },
    closeMenu() {
      this.isMenuOpen = false;
    }
  }
};
</script>

<style scoped>
.CarShopNavbar {
  background: linear-gradient(90deg, #141e30, #243b55);
  backdrop-filter: blur(5px);
  box-shadow: 0 4px 30px rgba(0, 0, 0, 0.3);
  padding: 1rem 2rem;
  position: sticky;
  top: 0;
  z-index: 1000;
  border-bottom: 1px solid rgba(255, 255, 255, 0.1);
  font-family: 'Poppins', sans-serif;
}

.nav-container {
  max-width: 1400px;
  margin: 0 auto;
  display: flex;
  align-items: center;
  justify-content: space-between;
  position: relative;
}

.nav-logo a {
  font-size: 2rem;
  font-weight: 700;
  background: linear-gradient(45deg, #f39c12, #e74c3c);
  -webkit-background-clip: text;
  background-clip: text;
  color: transparent;
  text-decoration: none;
  letter-spacing: -1px;
}

.nav-links {
  list-style: none;
  display: flex;
  gap: 3rem;
  margin: 0;
  padding: 0;
}

.nav-links li a {
  text-decoration: none;
  color: #fff;
  font-size: 1.1rem;
  font-weight: 500;
  padding: 0.2rem 0.1rem;
  border-radius: 8px;
  transition: all 0.3s cubic-bezier(0.175, 0.885, 0.32, 1.275);
  position: relative;
}

.nav-links li a:hover {
  background: rgba(255, 255, 255, 0.1);
  transform: translateY(-2px);
}

.nav-links li a::before {
  content: '';
  position: absolute;
  bottom: -5px;
  left: 50%;
  transform: translateX(-50%);
  width: 0;
  height: 3px;
  background: linear-gradient(45deg, #f39c12, #e74c3c);
  border-radius: 2px;
  transition: width 0.3s ease;
}

.nav-links li a:hover::before {
  width: 60%;
}

.active {
  font-weight: 600 !important;
}

.active::before {
  width: 60% !important;
}

/* Hamburger-Menü */
.mobile-menu-icon {
  display: none;
  flex-direction: column;
  cursor: pointer;
}

.mobile-menu-icon span {
  display: block;
  width: 25px;
  height: 3px;
  margin: 5px 0;
  background: #fff;
  transition: all 0.3s ease;
}

/* Responsive Design */
@media (max-width: 768px) {
  .mobile-menu-icon {
    display: flex;
  }

  /* Navigation als Dropdown im Mobile-Menu */
  .nav-links {
    position: absolute;
    top: 100%;
    left: 0;
    right: 0;
    background: linear-gradient(90deg, #141e30, #243b55);
    flex-direction: column;
    align-items: Center;
    max-height: 0;
    overflow: hidden;
    transition: max-height 0.3s ease-in-out;
  }
  
  .nav-links.mobile-open {
    max-height: 1000px; /* Erhöhter Wert, damit alle Links sichtbar sind */
  }
  
  .nav-links li {
    margin: 1rem 0;
  }
  
  .nav-links li a {
    font-size: 1rem;
    padding: 0.1rem 0.2rem;
  }
}

/* header-Bereich */
.header {
  position: relative;
  height: 400px;
  display: flex;
  align-items: center;
  justify-content: center;
  background: url('@/assets/header-car.webp') center center/cover no-repeat;
  margin-bottom: 2rem;
}

.header h1 {
  padding-bottom: 25px;
}

/* Overlay, um den Text lesbar zu machen */
.header-overlay {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(0, 0, 0, 0.6);
}

/* Inhalt im header-Bereich */
.header-content {
  position: relative;
  z-index: 1;
  color: #fff;
  text-align: center;
  padding: 0 1rem;
}

.header-content h1 {
  font-size: 2.1rem;
  margin-bottom: 1rem;
}

.header-content p {
  font-size: 1.2rem;
  line-height: 1.6;
  margin: 0.5rem 0;
}
</style>