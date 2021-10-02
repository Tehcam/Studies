class Personne < ApplicationRecord
    has_many :voitures
    has_and_belongs_to_many :voyages

    def to_s
        nom + " " + prenom
    end
end
