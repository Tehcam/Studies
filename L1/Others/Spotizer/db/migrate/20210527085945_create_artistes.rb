class CreateArtistes < ActiveRecord::Migration[6.0]
  def change
    create_table :artistes do |t|
      t.string :nom

      t.timestamps
    end
  end
end
