import { createRouter, createWebHashHistory } from 'vue-router'

import Translator from '@/views/Translator.vue'
import Edit from '@/views/Edit.vue'
import List from '@/views/List.vue'

const routes = [
    {
        path: '/translate',
        component: Translator
    },
    {
        path: '/edit/:id?',
        component: Edit
    },
    {
        path: '/list',
        component: List
    }
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router