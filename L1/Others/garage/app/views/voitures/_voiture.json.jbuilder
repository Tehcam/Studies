json.extract! voiture, :id, :immatriculation, :couleur, :marque, :modele, :date_mise_en_service, :created_at, :updated_at
json.url voiture_url(voiture, format: :json)
