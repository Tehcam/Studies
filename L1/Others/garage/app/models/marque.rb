class Marque < ApplicationRecord
    has_many :voitures
    accepts_nested_attributes_for :voitures, allow_destroy: true

    def to_s
        nom
    end
end
