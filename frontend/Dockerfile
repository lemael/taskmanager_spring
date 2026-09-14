# --- Étape 1 : Build Node.js ---
FROM node:22-alpine AS builder
WORKDIR /app

# ✅ Déclarer l'argument de build pour l'URL API Railway
ARG VITE_API_BASE_URL=https://backend-production-32fb.up.railway.app/api
ENV VITE_API_BASE_URL=$VITE_API_BASE_URL

COPY package*.json ./
RUN npm install --legacy-peer-deps

COPY . .
RUN npm run build

# --- Étape 2 : Serveur Nginx ---
FROM nginx:alpine
WORKDIR /usr/share/nginx/html

# Nettoyage du dossier par défaut de Nginx
RUN rm -rf ./*

# Copie des fichiers compilés (dist) depuis la phase de build
COPY --from=builder /app/dist .

# ✅ Copie de la configuration Nginx personnalisée pour gérer Vue Router
COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]