class Rayon < ApplicationRecord
    has_many :items
    accepts_nested_attributes_for :items, allow_destroy: true

    def to_s
        label
    end
end
