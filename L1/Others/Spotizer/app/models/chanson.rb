class Chanson < ApplicationRecord
    belongs_to :artiste
    belongs_to :album

    def to_s
        titre
    end
end
