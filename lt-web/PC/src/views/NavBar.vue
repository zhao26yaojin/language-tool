<template>
    <div class="nav">
        <img class="icon" src="../assets/icon.jpeg" />
        <h2 class="title">Rosetta</h2>
        <div class="space"></div>
        <ul>
            <router-link class="menuItem" to="/translate">Translate</router-link>
            <router-link class="menuItem" to="/edit">Edit</router-link>
            <router-link class="menuItem" to="/list">List</router-link>
        </ul>
    </div>
</template>


<style>
.nav {
    height: 80px;
    margin-top: 0;
    display: flex;
    align-items: center;
    border-bottom: 1px solid #ddd;
    padding: 0 5px;

}

.icon {
    height: 50px;
    vertical-align: middle;
}

.menuItem {
    margin: 10px;
}

.title {
    display: inline-block;
    margin-left: 5px;
}

.space {
    width: 100%;
}
</style>