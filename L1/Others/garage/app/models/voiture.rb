class Voiture < ApplicationRecord

    @@id = 0
    belongs_to :personne, optional: true
    belongs_to :marque

    def to_s
        [marque.to_s, " ", modele, " appartenant à ", personne||"personne"].compact.join
    end

    def self.import_voitures path="./db/voitures.xml"
        content = File.read(path)
        h = Hash.from_xml content
        # debugger
        nb_voiture = h["voitures"].count - 1
        (0..nb_voiture).each do |i|
            current_marque_id = h["voitures"][i]["marque"]["id"]
            current_marque = nil
            if Marque.where(id: current_marque_id).count == 0
                current_marque = Marque.new
                current_marque.id = current_marque_id
                current_marque.nom = h["voitures"][i]["marque"]["nom"]
                current_marque.save
            end
            current_marque = Marque.where(id: current_marque_id).first
            v = Voiture.new
            v.immatriculation = h["voitures"][i]["immatriculation"]
            v.couleur = h["voitures"][i]["couleur"]
            v.id = h["voitures"][i]["id"]
            v.modele = h["voitures"][i]["modele"]
            v.marque = current_marque
            v.marque_id = current_marque_id
            v.save!
        end
    end
end
