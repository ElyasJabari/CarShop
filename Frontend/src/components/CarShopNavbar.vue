<template>
  <div>
    <nav class="CarShopNavbar">
      <div class="nav-container">
        <div class="nav-logo">
          <a href="#">CarShop</a>
        </div>
        <ul class="nav-links">
          <li><a href="#" @click.prevent="$emit('show-all')" :class="{ active: !showFavorites }">Startseite</a></li>
          <li><a href="#">Über uns</a></li>
          <li><a href="#">Kontakt</a></li>
          <li><a href="#" @click.prevent="$emit('show-favorites')" :class="{ active: showFavorites }">Favoriten</a></li>
        </ul>
      </div>
    </nav>

  <!-- header-Bereich mit Hintergrundbild -->
    <section class="header">
      <div class="header-overlay"></div>
      <div class="header-content">
        <h1>Willkommen bei CarShop – Ihrem Online-Portal für Autos! 🚗✨</h1>
        <p>
          Entdecken Sie eine große Auswahl an Fahrzeugen mit detaillierten Informationen zu jedem Modell.
        </p>
        <p>
          Egal, ob Sie nach einem sportlichen Flitzer, einem komfortablen Familienauto oder einem sparsamen Stadtauto suchen – bei uns finden Sie alle wichtigen Details auf einen Blick.
        </p>
        <p>
          Klicken Sie auf ein Auto, um mehr über seine Ausstattung, Leistung und Besonderheiten zu erfahren. Lassen Sie sich inspirieren und finden Sie Ihr Traumauto ganz bequem online!
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
  }
};
</script>

<style scoped>
.CarShopNavbar {
  background-color: #f3e9cf;
  box-shadow: 0 2px 4px rgba(0,0,0,0.1);
  padding: 0.5rem 1rem;
  position: sticky;
  top: 0;
  z-index: 100;
}

.nav-container {
  max-width: 1200px;
  margin: 0 auto;
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.nav-logo a {
  font-size: 1.5rem;
  font-weight: bold;
  color: #333;
  text-decoration: none;
}

.nav-links {
  list-style: none;
  display: flex;
  gap: 1.5rem;
  margin: 0;
  padding: 0;
}

.nav-links li a {
  text-decoration: none;
  color: #333;
  font-size: 1rem;
  transition: color 0.2s ease;
}

.nav-links li a:hover {
  color: #007bff;
}

.active {
  text-decoration: underline !important;
  font-weight: bold;
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